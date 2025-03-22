package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.DingdanxinxiEntity;
import com.entity.OrdersEntity;
import com.entity.ShangjiaEntity;
import com.entity.ShangpinxinxiEntity;
import com.entity.view.OrdersView;
import com.service.DingdanxinxiService;
import com.service.OrdersService;
import com.service.ShangjiaService;
import com.service.ShangpinxinxiService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 订单
 * 后端接口
 *
 * @author
 * @email
 * @date 2021-04-04 23:32:25
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @Resource
    private DingdanxinxiService dingdanxinxiService;

    @Resource
    private ShangjiaService shangjiaService;

    @Resource
    private ShangpinxinxiService shangpinxinxiService;

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, OrdersEntity orders,
                  HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        if (!request.getSession().getAttribute("role").toString().equals("管理员")) {
            orders.setUserid(userId);
        }

        if (request.getSession().getAttribute("role").toString().equals("商家")) {
            orders.setUserid(null);

            // 通过 userID 查询 用户信心
            ShangjiaEntity shangjiaEntity = shangjiaService.selectById(userId);
            String shangjiazhanghao = shangjiaEntity.getShangjiazhanghao();
            // 通过商家账号查询订单
            orders.setShangjiazhanghao(shangjiazhanghao);
            params.put("shangjiazhanghao", shangjiazhanghao);
        }

        EntityWrapper<OrdersEntity> ew = new EntityWrapper<OrdersEntity>();
        PageUtils page = ordersService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, orders), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, OrdersEntity orders, HttpServletRequest request) {
        EntityWrapper<OrdersEntity> ew = new EntityWrapper<OrdersEntity>();
        PageUtils page = ordersService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, orders), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(OrdersEntity orders) {
        EntityWrapper<OrdersEntity> ew = new EntityWrapper<OrdersEntity>();
        ew.allEq(MPUtil.allEQMapPre(orders, "orders"));
        return R.ok().put("data", ordersService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(OrdersEntity orders) {
        EntityWrapper<OrdersEntity> ew = new EntityWrapper<OrdersEntity>();
        ew.allEq(MPUtil.allEQMapPre(orders, "orders"));
        OrdersView ordersView = ordersService.selectView(ew);
        return R.ok("查询订单成功").put("data", ordersView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        OrdersEntity orders = ordersService.selectById(id);
        return R.ok().put("data", orders);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        OrdersEntity orders = ordersService.selectById(id);
        return R.ok().put("data", orders);
    }


    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody OrdersEntity orders, HttpServletRequest request) {
        orders.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(orders);
        orders.setUserid((Long) request.getSession().getAttribute("userId"));
        ordersService.insert(orders);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody OrdersEntity orders, HttpServletRequest request) {
        long id = new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue();
        orders.setId(id);
        //ValidatorUtils.validateEntity(orders);
        ordersService.insert(orders);
        // 通过订单ID 查询订单信息
        OrdersEntity ordersEntity = ordersService.selectById(id);
        Long goodid = ordersEntity.getGoodid();
        ShangpinxinxiEntity shangpinxinxiEntity = shangpinxinxiService.selectById(goodid);
        ordersEntity.setShangjiazhanghao(shangpinxinxiEntity.getShangjiazhanghao());
        ordersService.updateById(ordersEntity);
        // 插入订单信息表
        DingdanxinxiEntity dingdanxinxiEntity = convByOrderId(ordersEntity);
        dingdanxinxiService.insert(dingdanxinxiEntity);
        return R.ok();
    }

    private DingdanxinxiEntity convByOrderId(OrdersEntity ordersEntity) {
        Long goodid = ordersEntity.getGoodid();
        ShangpinxinxiEntity shangpinxinxiEntity = shangpinxinxiService.selectById(goodid);

        DingdanxinxiEntity dingdanxinxiEntity = new DingdanxinxiEntity();
        dingdanxinxiEntity.setAddtime(ordersEntity.getAddtime());
        dingdanxinxiEntity.setId(ordersEntity.getId());
        dingdanxinxiEntity.setDingdanhao(ordersEntity.getOrderid());
        dingdanxinxiEntity.setShangpinmingcheng(shangpinxinxiEntity.getShangpinmingcheng());
        dingdanxinxiEntity.setShangpinleixing(shangpinxinxiEntity.getShangpinleixing());
        dingdanxinxiEntity.setTupian(shangpinxinxiEntity.getTupian());
        dingdanxinxiEntity.setShangjiazhanghao(shangpinxinxiEntity.getShangjiazhanghao());
        dingdanxinxiEntity.setShangjiamingcheng(shangpinxinxiEntity.getShangjiamingcheng());
        dingdanxinxiEntity.setYuezujiage(shangpinxinxiEntity.getYuezujiage());
        dingdanxinxiEntity.setZhanghao(shangpinxinxiEntity.getShangjiazhanghao());
        dingdanxinxiEntity.setXingming(shangpinxinxiEntity.getShangjiamingcheng());
        dingdanxinxiEntity.setShouji(ordersEntity.getTel());
        dingdanxinxiEntity.setDizhi(ordersEntity.getAddress());
        // 租赁月长
//        dingdanxinxiEntity.setZulinyuezhang();
        dingdanxinxiEntity.setJine(ordersEntity.getPrice());
        dingdanxinxiEntity.setDingdanzhuangtai(ordersEntity.getStatus());
        dingdanxinxiEntity.setSfsh("否");
        dingdanxinxiEntity.setShhf("");
        dingdanxinxiEntity.setIspay("未支付");
        return dingdanxinxiEntity;
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody OrdersEntity orders, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(orders);
        ordersService.updateById(orders);//全部更新
        Map map = new HashMap();
        map.put("dingdanhao", orders.getOrderid());
        List<DingdanxinxiEntity> list = dingdanxinxiService.selectByMap(map);
        list.forEach(dingdanxinxiEntity -> {
            dingdanxinxiEntity.setDingdanzhuangtai(orders.getStatus());
            dingdanxinxiService.updateById(dingdanxinxiEntity);
        });
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        ordersService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 提醒接口
     */
    @RequestMapping("/remind/{columnName}/{type}")
    public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
                         @PathVariable("type") String type, @RequestParam Map<String, Object> map) {
        map.put("column", columnName);
        map.put("type", type);

        if (type.equals("2")) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            Date remindStartDate = null;
            Date remindEndDate = null;
            if (map.get("remindstart") != null) {
                Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH, remindStart);
                remindStartDate = c.getTime();
                map.put("remindstart", sdf.format(remindStartDate));
            }
            if (map.get("remindend") != null) {
                Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH, remindEnd);
                remindEndDate = c.getTime();
                map.put("remindend", sdf.format(remindEndDate));
            }
        }

        Wrapper<OrdersEntity> wrapper = new EntityWrapper<OrdersEntity>();
        if (map.get("remindstart") != null) {
            wrapper.ge(columnName, map.get("remindstart"));
        }
        if (map.get("remindend") != null) {
            wrapper.le(columnName, map.get("remindend"));
        }
        if (!request.getSession().getAttribute("role").toString().equals("管理员")) {
            wrapper.eq("userid", (Long) request.getSession().getAttribute("userId"));
        }


        int count = ordersService.selectCount(wrapper);
        return R.ok().put("count", count);
    }


}

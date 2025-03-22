const menu = {
    list() {
        return [
            {
                "backMenu": [
                    {
                        "child": [
                            {
                                "buttons": [
                                    "新增",
                                    "查看",
                                    "修改",
                                    "删除"
                                ],
                                "menu": "用户",
                                "menuJump": "列表",
                                "tableName": "yonghu"
                            }
                        ],
                        "menu": "用户管理"
                    },
                    {
                        "child": [
                            {
                                "buttons": [
                                    "新增",
                                    "查看",
                                    "修改",
                                    "删除"
                                ],
                                "menu": "商家",
                                "menuJump": "列表",
                                "tableName": "shangjia"
                            }
                        ],
                        "menu": "商家管理"
                    },
                    {
                        "child": [
                            {
                                "buttons": [
                                    "查看",
                                    "新增",
                                    "修改",
                                    "删除",
                                    "查看评论"
                                ],
                                "menu": "商品信息",
                                "menuJump": "列表",
                                "tableName": "shangpinxinxi"
                            }
                        ],
                        "menu": "商品信息管理"
                    },
                    {
                        "child": [
                            {
                                "buttons": [
                                    "新增",
                                    "查看",
                                    "修改",
                                    "删除"
                                ],
                                "menu": "商品分类",
                                "menuJump": "列表",
                                "tableName": "shangpinfenlei"
                            }
                        ],
                        "menu": "商品分类管理"
                    },
                    {
                        "child": [
                            {
                                "buttons": [
                                    "查看",
                                    "修改",
                                    "删除"
                                ],
                                "menu": "订单信息",
                                "menuJump": "列表",
                                "tableName": "dingdanxinxi"
                            }
                        ],
                        "menu": "订单信息管理"
                    },
                    {
                        "child": [
                            {
                                "buttons": [
                                    "查看",
                                    "修改",
                                    "删除"
                                ],
                                "menu": "发货订单",
                                "menuJump": "列表",
                                "tableName": "fahuodingdan"
                            }
                        ],
                        "menu": "发货订单管理"
                    },
                    {
                        "child": [
                            {
                                "buttons": [
                                    "查看",
                                    "修改",
                                    "删除"
                                ],
                                "menu": "租借订单",
                                "menuJump": "列表",
                                "tableName": "zujiedingdan"
                            }
                        ],
                        "menu": "租借订单管理"
                    },
                    {
                        "child": [
                            {
                                "buttons": [
                                    "查看",
                                    "修改",
                                    "删除"
                                ],
                                "menu": "完成订单",
                                "menuJump": "列表",
                                "tableName": "wanchengdingdan"
                            }
                        ],
                        "menu": "完成订单管理"
                    },
                    {
                        "child": [
                            {
                                "buttons": [
                                    "新增",
                                    "查看",
                                    "修改",
                                    "删除"
                                ],
                                "menu": "信誉值",
                                "menuJump": "列表",
                                "tableName": "xinyuzhi"
                            }
                        ],
                        "menu": "信誉值管理"
                    },
                    {
                        "child": [
                            {
                                "buttons": [
                                    "新增",
                                    "查看",
                                    "修改",
                                    "删除"
                                ],
                                "menu": "轮播图管理",
                                "tableName": "config"
                            }
                        ],
                        "menu": "系统管理"
                    },
                    {
                        "child": [
                            {
                                "buttons": [
                                    "查看",
                                    "修改",
                                    "删除"
                                ],
                                "menu": "未支付订单",
                                "tableName": "orders/未支付"
                            },
                            {
                                "buttons": [
                                    "查看",
                                    "修改",
                                    "删除"
                                ],
                                "menu": "已取消订单",
                                "tableName": "orders/已取消"
                            },
                            {
                                "buttons": [
                                    "查看",
                                    "修改",
                                    "删除"
                                ],
                                "menu": "已支付订单",
                                "tableName": "orders/已支付"
                            },
                            {
                                "buttons": [
                                    "查看",
                                    "修改",
                                    "删除"
                                ],
                                "menu": "已退款订单",
                                "tableName": "orders/已退款"
                            },
                            {
                                "buttons": [
                                    "查看",
                                    "修改",
                                    "删除"
                                ],
                                "menu": "已完成订单",
                                "tableName": "orders/已完成"
                            },
                            {
                                "buttons": [
                                    "查看",
                                    "修改",
                                    "删除"
                                ],
                                "menu": "已发货订单",
                                "tableName": "orders/已发货"
                            }
                        ],
                        "menu": "订单管理"
                    }
                ],
                "frontMenu": [
                    {
                        "child": [
                            {
                                "buttons": [
                                    "查看",
                                    "查看评论",
                                    "租赁"
                                ],
                                "menu": "商品信息列表",
                                "menuJump": "列表",
                                "tableName": "shangpinxinxi"
                            }
                        ],
                        "menu": "商品信息模块"
                    }
                ],
                "hasBackLogin": "是",
                "hasBackRegister": "否",
                "hasFrontLogin": "否",
                "hasFrontRegister": "否",
                "roleName": "管理员",
                "tableName": "users"
            },
            {
                "backMenu": [
                    {
                        "child": [
                            {
                                "buttons": [
                                    "删除",
                                    "支付",
                                    "修改",
                                    "查看"
                                ],
                                "menu": "订单信息",
                                "menuJump": "列表",
                                "tableName": "dingdanxinxi"
                            }
                        ],
                        "menu": "订单信息管理"
                    },
                    {
                        "child": [
                            {
                                "buttons": [
                                    "查看",
                                    "收货"
                                ],
                                "menu": "发货订单",
                                "menuJump": "列表",
                                "tableName": "fahuodingdan"
                            }
                        ],
                        "menu": "发货订单管理"
                    },
                    {
                        "child": [
                            {
                                "buttons": [
                                    "查看",
                                    "归还"
                                ],
                                "menu": "租借订单",
                                "menuJump": "列表",
                                "tableName": "zujiedingdan"
                            }
                        ],
                        "menu": "租借订单管理"
                    },
                    {
                        "child": [
                            {
                                "buttons": [
                                    "查看"
                                ],
                                "menu": "完成订单",
                                "menuJump": "列表",
                                "tableName": "wanchengdingdan"
                            }
                        ],
                        "menu": "完成订单管理"
                    },
                    {
                        "child": [
                            {
                                "buttons": [
                                    "新增",
                                    "查看",
                                    "修改",
                                    "删除"
                                ],
                                "menu": "我的收藏管理",
                                "tableName": "storeup"
                            }
                        ],
                        "menu": "我的收藏管理"
                    }
                ],
                "frontMenu": [
                    {
                        "child": [
                            {
                                "buttons": [
                                    "查看",
                                    "查看评论",
                                    "租赁"
                                ],
                                "menu": "商品信息列表",
                                "menuJump": "列表",
                                "tableName": "shangpinxinxi"
                            }
                        ],
                        "menu": "商品信息模块"
                    }
                ],
                "hasBackLogin": "否",
                "hasBackRegister": "否",
                "hasFrontLogin": "是",
                "hasFrontRegister": "是",
                "roleName": "用户",
                "tableName": "yonghu"
            },
            {
                "backMenu": [
                    {
                        "child": [
                            {
                                "buttons": [
                                    "查看",
                                    "新增",
                                    "修改",
                                    "删除",
                                    "查看评论"
                                ],
                                "menu": "商品信息",
                                "menuJump": "列表",
                                "tableName": "shangpinxinxi"
                            }
                        ],
                        "menu": "商品信息管理"
                    },
                    {
                        "child": [
                            {
                                "buttons": [
                                    "查看",
                                    "审核",
                                    "发货"
                                ],
                                "menu": "订单信息",
                                "menuJump": "列表",
                                "tableName": "dingdanxinxi"
                            }
                        ],
                        "menu": "订单信息管理"
                    },
                    {
                        "child": [
                            {
                                "buttons": [
                                    "查看"
                                ],
                                "menu": "发货订单",
                                "menuJump": "列表",
                                "tableName": "fahuodingdan"
                            }
                        ],
                        "menu": "发货订单管理"
                    },
                    {
                        "child": [
                            {
                                "buttons": [
                                    "查看"
                                ],
                                "menu": "租借订单",
                                "menuJump": "列表",
                                "tableName": "zujiedingdan"
                            }
                        ],
                        "menu": "租借订单管理"
                    },
                    {
                        "child": [
                            {
                                "buttons": [
                                    "查看",
                                    "审核"
                                ],
                                "menu": "完成订单",
                                "menuJump": "列表",
                                "tableName": "wanchengdingdan"
                            }
                        ],
                        "menu": "完成订单管理"
                    },
                    {
                        "child": [
                            {
                                "buttons": [
                                    "查看"
                                ],
                                "menu": "信誉值",
                                "menuJump": "列表",
                                "tableName": "xinyuzhi"
                            }
                        ],
                        "menu": "信誉值管理"
                    },
                    {
                        "child": [
                            {
                                "buttons": [
                                    "查看"
                                ],
                                "menu": "已退款订单",
                                "tableName": "orders/已退款"
                            },
                            {
                                "buttons": [
                                    "查看"
                                ],
                                "menu": "已完成订单",
                                "tableName": "orders/已完成"
                            },
                            {
                                "buttons": [
                                    "查看"
                                ],
                                "menu": "已发货订单",
                                "tableName": "orders/已发货"
                            },
                            {
                                "buttons": [
                                    "查看"
                                ],
                                "menu": "未支付订单",
                                "tableName": "orders/未支付"
                            },
                            {
                                "buttons": [
                                    "查看"
                                ],
                                "menu": "已取消订单",
                                "tableName": "orders/已取消"
                            },
                            {
                                "buttons": [
                                    "发货",
                                    "查看"
                                ],
                                "menu": "已支付订单",
                                "tableName": "orders/已支付"
                            }
                        ],
                        "menu": "订单管理"
                    }
                ],
                "frontMenu": [
                    {
                        "child": [
                            {
                                "buttons": [
                                    "查看",
                                    "查看评论",
                                    "租赁"
                                ],
                                "menu": "商品信息列表",
                                "menuJump": "列表",
                                "tableName": "shangpinxinxi"
                            }
                        ],
                        "menu": "商品信息模块"
                    }
                ],
                "hasBackLogin": "是",
                "hasBackRegister": "是",
                "hasFrontLogin": "是",
                "hasFrontRegister": "是",
                "roleName": "商家",
                "tableName": "shangjia"
            }
        ]
    }
}
export default menu;

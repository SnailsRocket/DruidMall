## DruidMall
### description
> 这个项目是平常自己做测试用的
> 这个项目目前出了问题，所有的请求都是404 ,查了问题是 SpringBoot内置的Tomcat 没有正常关闭

### 设计一个页面，通过弹出框进行增删改查
#### 设计数据库
> 

### 餐厅点餐排队系统
> 1.用户模块
> 2.点餐模块
> 3.订单模块
> 4.支付模块
> 5.商品展示模块
> 6.购物车模块
>
#### 流程
> 用户扫码进入 OrderSystem，然后进入主页面，主页面介绍餐厅(主要是环境，特色等)，中央位置有一个预订连接，点击跳转预订界面
> 预订界面显示店内一些菜品信息，以及折扣
> 选择套餐，座位号，到店时间(用户晚到怎么办)，点击预订，到预订时间后，会有短信通知，如果用户五分钟内不来，预订座位将被释放
> 用户进店用餐后，则改变预订订单的状态，用户离店则设置该座位号为可预订(不离店也可以预订)(预订的时候可以选择座位号，没有座位号也可以预订)
>  
>
>
#### 数据库设计 ordersystem
>  user(用户表，会员)：
>   user_id username password nickname birth member phone gender is_admin pwd_reset_time create_time update_time
>   is_admin 1 true 0 false  member 1 true 0 false
>
>  menu(菜品表)：
>   menu_id name money image(存储的是路径) sales(销量) 
>
>  combo(套餐)：
>   combo_id menu_id coupon_id coupon_money total_money
>
>  seat(座位表)：
>   seat_id people_num seat_name seat_status
>   seat_status 1 有人 0 没人
>
>  order(订单表)：
>   order_id user_id seat_id(one or null) create_time order_status total_money 
>   order_status 1 订单完成 0 订单未完成
>
>  order_menu(中间表)：
>   order_id menu_id
>
>  combo_menu(中间表)：
>   combo_id menu_id
>
>  coupon(优惠券)：
>   coupon_id coupon description
>
>  introduce(商家介绍)：
>   introduce_id mall_name description image location phone 
>
>  menu_top(菜单推荐)：
>   menu_top_id menu_id coupon_money total_money
>
>  message(留言)：
>   message_id user_id menu_id context create_time status
>   status 1 未删除 0 删除

#### 项目进度
#####  完成商品展示页面：
>   这里涉及到图片存储问题(目前的解决方案是放在本地，暂时不放在服务器上面，将远程连接写到mysql里面(image字段))
>   菜品展示页面 ： menu_name money sales 加入购物车(按钮) 份数选择 
>   
   
   


#### 问题
> 原型图没有画好
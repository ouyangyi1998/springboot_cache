# 利用springboot缓存cache（ConcurrenMapCacheManager）
- 代码来自github @forezp 感谢大佬
- 每一次操作控制延时Thread.sleep()来模拟数据库操作延时
- 不使用其他第三方缓存依赖的时候，springboot自动采用ConcurrenMapCacheManager作为缓存管理器
- 在启动类中添加注解@EnableCaching开启缓存控制
- 在dao层或者service利用注解@Cachable()启动缓存 
- @Caching的value属性是必须指定的，其表示当前方法的返回值是会被缓存在哪个Cache上的，对应Cache的名称
   - 其可以是一个Cache也可以是多个Cache，当需要指定多个Cache时其是一个数组
- key属性是用来指定Spring缓存方法的返回结果时对应的key的。该属性支持SpringEL表达式
***
- 平常开发中有可能需要实现在项目启动后执行的功能，SpringBoot提供的一种简单的实现方案就是添加一个model并实现CommandLineRunner接口，实现功能的代码放在实现的run方法中
- 如果有多个类实现CommandLineRunner接口，如何保证顺序
   - SpringBoot在项目启动后会遍历所有实现CommandLineRunner的实体类并执行run方法，
   - 如果需要按照一定的顺序去执行，那么就需要在实体类上使用一个@Order注解（或者实现Order接口）来表明顺序

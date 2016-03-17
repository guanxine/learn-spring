# Spring

##Spring - IoC Containers
Two distince types of containers

1. Spring BeanFactory Container
	* used for light weight applications
2. Spring ApplicationContext Container(recommended)
	* includes all functionality of the BeanFactory container

##Spring - Bean Definition

the container need to know:

1. How to create a bean
2. Bean's lifecycle details
3. Bean's dependencies

|Properties|Description|
|-|-|
|class|mandatory,create the bean|
|name/id| the bean identifier uniquely|
|scope|bean scopes|
|constructor-arg|inject the dependencies|
|properties|inject the dependencies|
|autowiring mode|inject the dependencies |
|lazy-initialization mode|create first requested, rather than at startup |
|initialization method|be called  on the bean instantiation,life cycle |
|destruction method|be called before a bean is removed from the container,life cycle|


Spring Configuration Metadata(3)

1. XML based configuration file.
2. Annotation-based configuration
3. Java-based configuration

## Spring - Bean Scopes
five scopes

|Scope|Description|web-aware ApplicationContext|
|-|-|-|
|singleton|a single instance(default)|
|prototype| any number|
|request|an HTTP request|Only Valid|
|session|an HTTP session|Only Valid|
|global-session|a global HTTP session|Only Valid|

## Spring - Bean Life Cycle

To define setup and teardown for a bean, we simply declare the <bean> with init-method and/or destroy-method parameters.

## Spring - Bean Post Processors
You can also implement some custom logic after the Spring container finishes instantiating, configuring, and initializing a bean by plugging in one or more BeanPostProcessor implementations.

##Spring - Bean Definition Inheritance
When you use XML-based configuration metadata, you indicate a child bean definition by using the **parent** attribute, specifying the parent bean as the value of this attribute.

##Spring - Dependency Injection

DI exists in two major variants

1. **Constructor-based DI**
   is accomplished when the container invokes a class constructor
2. **Setter-based DI**
	accomplished by the container calling setter methods


##Spring - Injecting Inner Beans
a <bean/> element inside the <property/> or <constructor-arg/> elements is called inner bean

##Spring - Injecting Collection

|Element|Description|
|-|-|
|`value`|primitive data type |
|`ref`|object references|
|`<list>`|a list of values,duplicates|
|`<set>`|a set of values,without any duplicates|
|`<map>`|a collection of name-value pairs,any type|
|`<props>`|a collection of name-value pairs, both Strings|

##Spring - Beans Auto-Wiring

Autowiring Modes

|Mode|Description|
|-|-|
|no|explicit bean reference|
|byName|property name|
|byType|property datatype,exception:matches more than one|
|constructor|constructor arguments,error:not exactly constructor argument |
|autodetect|constructor->byType|

using <constructor-arg> and <property> settings which will always override autowiring.

##Spring - Annotation Based Configuration(2.5)

* instead of using XML
* using annotations on the relevant class, method, or field declaration
* not turned on in the Spring container by default.

`<context:annotation-config/>`
```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context-3.0.xsd">

   <context:annotation-config/>
   <!-- bean definitions go here -->

</beans>
```
few important annotations

|||
|-|-|
|@Required |bean property setter methods|
|@Autowired|bean property setter methods, non-setter methods, constructor and properties|
|@Qualifier |along with @Autowired,specifiying  exact bean|
|JSR-250 Annotations||

## Spring - Java Based Configuration
* instead of using XML

## Event Handling in Spring

1. ContextRefreshedEvent
	when the ApplicationContext is either initialized or refreshed.
    * ConfigurableApplicationContext
2. ContextStartedEvent
	when the ApplicationContext is started using the start()
    * ConfigurableApplicationContext
3. ContextStoppedEvent
	when the ApplicationContext is stopped using the stop()
4. ContextClosedEvent
	when the ApplicationContext is closed using the close()
5. RequestHandledEvent
	This is a web-specific event telling all beans that an HTTP request has been serviced

Listening to Context Events:implement the` ApplicationListener`

## Custom Events in Spring
1. Event extends ApplicationEvent
2. EventHandler implements ApplicationListener
3. EventPublisher implements ApplicationEventPublisherAware


## AOP with Spring Framework
Aspect oriented programming (AOP)

Example

logging, auditing, declarative transactions, security, and caching etc.

OOP unit:Class
AOP unit:aspect


Spring AOP module provides interceptors to intercept an application

AOP Terminologies:

|Terms|Description|
|-|-|
|Aspect|A module which has a set of APIs providing cross-cutting requirements.|
|Join point|a point using Spring AOP |
|Advice|the actual action either  to be taken  before or after the method execution|
|Pointcut|a set of one or more joinpoints where an advice should be executed.|
|Introduction| allows you to add new methods or attributes to existing classes.|
|Target object|advised by one or more aspects，proxied object，advised object|
|Weaving|the process of linking aspects with other application types or objects to create an advised object,This can be done at compile time, load time, or at runtime|

Types of Advice:

|Advice|Description|
|-|-|
|before|before the a method execution|
|after|after the a method execution,regardless of its outcome|
|after-returning|after the a method execution,only if method completes successfully|
|after-throwing|after the a method execution only if method exits by throwing an exception|
|around|before and after the advised method is invoked|

###XML Schema Based AOP with Spring
1.  use the aop namespace,mport the spring-aop schema
	```
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
    xmlns:aop="http://www.springframework.org/schema/aop"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd 
    http://www.springframework.org/schema/aop 
    http://www.springframework.org/schema/aop/spring-aop-3.0.xsd ">

   <!-- bean definition & AOP specific configuration -->

	</beans>
	```
2. Declaring an aspect

	```
    <aop:config>
   	<aop:aspect id="myAspect" ref="aspectModule">
  	 ...
  	 </aop:aspect>
	</aop:config>

	<bean id="aspectModule" class="...">
		...
	</bean>
    ```
3. Declaring a pointcut
```
    <aop:config>
   	<aop:aspect id="myAspect" ref="aspectModule">
     	<aop:pointcut id="businessService"
     	 expression="execution(* com.xyz.myapp.service.*.*(..))"/>
  	 ...

  	 </aop:aspect>
	</aop:config>

	<bean id="aspectModule" class="...">
		...
	</bean>

    <!--execution(*「任意返回类型」 cn.*「任意包」.service..*「.* 是任意类名」.*(..)「任意方法」)-->
    ```


### @AspectJ Based AOP with Spring(Java 5 annotations)

```
<aop:aspectj-autoproxy/>
```

##Spring - JDBC Framework Overview

### JdbcTemplate

* the most popular approach
* manages all the database communication and exception handling
	* executes SQL queries, update statements and stored procedure calls
* threadsafe
	*  So you can configure a single instance。
	*  safely inject this shared reference into multiple DAOs

1. Configuring Data Source
	* supply a DataSource to the JdbcTemplate
2. Data Access Object (DAO)
	* makes it easy to work with data access technologies like JDBC, Hibernate, JPA or JDO in a consistent way.

3. Executing SQL statements

##Spring - Transaction Management
###ACID

* Atomicity：a single unit of operation，operations is successful or unsuccessful。
* Consistency：the referential integrity of the database
* Isolation：each transaction should be isolated from others to prevent data corruption
* Durability：Once a transaction has completed，the results have to be made permanent

###Spring Transaction Abstractions
* `org.springframework.transaction.PlatformTransactionManager`
* `TransactionDefinition`
* `TransactionStatus`

Following are the possible values for isolation level:
1. TransactionDefinition.ISOLATION_DEFAULT
2. TransactionDefinition.ISOLATION_READ_COMMITTED
3. TransactionDefinition.ISOLATION_READ_UNCOMMITTED
4. TransactionDefinition.ISOLATION_REPEATABLE_READ
5. TransactionDefinition.ISOLATION_SERIALIZABLE
**dirty reads:**
|t1|t2|
|-|-|
|SELECT age FROM users WHERE id = 1(age=20)||
||UPDATE users SET age = 21 WHERE id = 1;|
|SELECT age FROM users WHERE id = 1(age=21)||
||ROLLBACK|
**non-repeatable:**
|t1|t2|
|-|-|
|SELECT * FROM users WHERE id = 1;||
||UPDATE users SET age = 21 WHERE id = 1;|
||COMMIT;|
|SELECT * FROM users WHERE id = 1;||
|COMMIT; ||
**phantom reads:**
|t1|t2|
|-|-|
|SELECT * FROM users WHERE age BETWEEN 10 AND 30;||
||INSERT INTO users(id,name,age) VALUES ( 3, 'Bob', 27 );|
||COMMIT;||
|SELECT * FROM users WHERE age BETWEEN 10 AND 30;||
|COMMIT;||
Isolation Levels vs Read Phenomena:
|Isolation level|Dirty reads|Non-repeatable reads|Phantoms|
|-|-|-|-|
|Read Uncommitted|may occur|may occur|may occur|
|Read Committed|-|may occur|may occur|
|Repeatable Read|-|-|may occur|
|Serializable|-|-|-|
Isolation Levels vs Lock Duration:
|Isolation level|Write Operation|Read Operation|Range Operation (...where...)|
|-|-|-|-|
|Read Uncommitted|S|S|S|
|Read Committed|-|C|S|S|
|Repeatable Read|C|C|S|
|Serializable|C|C|C|

"C": locks are held until the transaction commits.
"S": locks are held only during the currently executing statement.

Following are the possible values for propagation types:
1. TransactionDefinition.PROPAGATION_MANDATORY
2. TransactionDefinition.PROPAGATION_NESTED
3. TransactionDefinition.PROPAGATION_NEVER
4. TransactionDefinition.PROPAGATION_NOT_SUPPORTED
5. TransactionDefinition.PROPAGATION_REQUIRED
6. TransactionDefinition.PROPAGATION_REQUIRES_NEW
7. TransactionDefinition.PROPAGATION_SUPPORTS
8. TransactionDefinition.TIMEOUT_DEFAULT

###Programmatic vs. Declarative:
1. Spring Programmatic Transaction Management

2. Spring Declarative Transaction Management
	* use annotations or XML based configuration
		* XML
			* <tx:advice /> :a transaction-handling advice
			* define a pointcut:
				1. the transaction before calling the method
				2. Target method will be executed in a try / catch block.
				3. success:commits,otherwise:otherwise.


## How Internal/External Communication Happens Between Database Servers 

### What is WAL (Write-Ahead-Log) in postgresql ?

- WAL is a definition of a transaction logs of a database. Each transaction is logging with 'pgoutput()' to logs. And Logical Replication can turn this row log data (INSERT INTO () VALUES ()) instead of low level readable log data (Binary/ Json)

### What is a Publication In a Database ?

- Data Flow
        Changes written on WAL. And the logical representation is provided by plugin ('pgoutput'). 
        Then a 'REPLICATION SLOT' created for each publisher to track which log should pub side discard looking for subscriptions of that publisher ! Keep tracking the data offsets in sum.

    - SQl Example to create a publisher:
      ~~~~postgresql
       CREATE PUBLICATION 
       app.products.pub 
       FOR TABLE app.t_product 
       WHERE on_sale = TRUE    | You can also add filtering on the published data ! 
       WITH (publish='insert,update,delete');
      ~~~~

### What is a Subscription In a Database ?

What is copy_data ? 
    - Copy data is showing the should publisher give a initial copy to sub of his WAL snapshot or not. So this case is generally uses for if i don't want to lose any data that is appending before the sub created and want to give this WAL as well choose 'copy_data = true'.
    
    
    SQl Example of creating a Subscription:

    ~~~~postgresql
    CREATE SUBSCRIPTION 
    app.products.sub
    CONNECTION 'host= pub_host_name dbname=pub_db_name user=pub_user_name password=pub_host_user_password'
    PUBLICATION app.products.pub
    WITH (slot_name= 'app.products.pub.slot' , copy_data = true/false)
  ~~~~

## What Debezium Stands For ?

## What is ELK (Elastic Search) ? 
    
    Elastic Stack -> [ElasticSearch(Hearth of the system),
                        Kibana (viusalizing and managing), 
                        Beats, 
                        Logstash] 
    
    No given #id for each document if not specified on the creation command ! 
    If an id trying to attach a new record must not be the same with the latest versison of that index ! 
    (POST index_name/_create/#id)
     
    
    
    
 

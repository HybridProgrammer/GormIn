# How to run
grails test-app -integration -Dgrails.env=test

Modify grails-app/services/oneisone/ExampleService.groovy
See comment and toggle lines of code

// To fix the test Toggle these two lines
        def user = me
//        def user = User.get(me.id)

or 

// To fix the test Toggle these two lines
//        def user = me
        def user = User.get(me.id)
        
Re run test:
grails test-app -integration -Dgrails.env=test

Repeat. You'll see inconsistant results in your test. The question: why?

# Querery Where from Spock Test Type I - Successful query
Hibernate: select count(*) as y0_ from user_data this_ inner join workflow_role_teams teams3_ on this_.id=teams3_.user_data_teams_id inner join role teams_alia1_ on teams3_.role_id=teams_alia1_.id where teams_alia1_.id in (?) limit ?

# Query Where from Service - Test Failure
Hibernate: select count(*) as y0_ from user_data this_ inner join workflow_role_teams teams3_ on this_.id=teams3_.user_data_teams_id inner join role teams_alia1_ on teams3_.role_id=teams_alia1_.id limit ?

Why did gorm not create a where clause?

Condition not satisfied:

query.size() == 2
|     |      |
|     20     false
grails.gorm.DetachedCriteria@280f061e

Expected :2

Actual   :20
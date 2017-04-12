package oneisone

import grails.gorm.DetachedCriteria
import grails.transaction.Transactional

@Transactional
class ExampleService {

    def getMyOrMyTeamsData(User me) {
        // To fix the test Toggle these two lines
        def user = me
//        def user = User.get(me.id)

        def teamIds = me.getAuthorities().id

        def query = UserData.where {
            teams { id in teamIds }
        }

        
        return query

    }
}

package by.bntu.dmitry.services.logsServices;

import by.bntu.dmitry.dao.LogsDAO;
import by.bntu.dmitry.entities.Logs;
import by.bntu.dmitry.entities.User;
import by.bntu.dmitry.enums.LogActions;
import java.sql.Date;

/**
 *
 * @author user
 */
public enum LogServices {

    INSTANCE;
    
    public void SignInLog(User user){
        Logs log = new Logs();
//        log.setDate(new Date(System.currentTimeMillis()));     //дата задается в sql-запросе now()
        log.setUser(user);
        log.setAction(LogActions.SIGN_IN);
        LogsDAO.INSTANCE.createEntity(log);
    }
    
    public void LogInLog(User user){
        Logs log = new Logs();
//        log.setDate(new Date(System.currentTimeMillis()));     //дата задается в sql-запросе now()
        log.setUser(user);
        log.setAction(LogActions.LOG_IN);
        LogsDAO.INSTANCE.createEntity(log);
    }
    
}

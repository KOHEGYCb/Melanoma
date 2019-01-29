package by.bntu.dmitry.services.logsServices;

import by.bntu.dmitry.dao.LogsDAO;
import by.bntu.dmitry.entities.Logs;
import by.bntu.dmitry.entities.User;
import by.bntu.dmitry.constants.LogActions;

/**
 *
 * @author dmitry
 */
public enum LogServices {

    INSTANCE;
    
    public void SignInLog(User user){
        LogsDAO.INSTANCE.createEntity(setLog(user, LogActions.SIGN_IN));
    }
    
    public void LogInLog(User user){
        LogsDAO.INSTANCE.createEntity(setLog(user, LogActions.LOG_IN));
    }

    public void LogOut(User user) {
        LogsDAO.INSTANCE.createEntity(setLog(user, LogActions.LOG_OUT));
    }
    
    private Logs setLog (User user, String action){
        Logs log = new Logs();
        log.setUser(user);
        log.setAction(action);
        return log;
    }
    
}

package ru.ivmiit.projectFixCource.listener;

import ru.ivmiit.projectFixCource.dao.ProductDao;
import ru.ivmiit.projectFixCource.dao.ProductDaoJdbcTemplateImpl;
import ru.ivmiit.projectFixCource.dao.StoreUserDao;
import ru.ivmiit.projectFixCource.dao.StoreUserDaoJDBCImpl;
import ru.ivmiit.projectFixCource.security.SecurityService;
import ru.ivmiit.projectFixCource.security.SecurityServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StoreServetContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            StoreUserDao storeUserDaoJdbc = new StoreUserDaoJDBCImpl();
            StoreUserDao storeUserDaoHibernate = new StoreUserDaoJDBCImpl();
            SecurityService securityService = new SecurityServiceImpl();
            ProductDao productDao=new ProductDaoJdbcTemplateImpl();

            ServletContext ctx = servletContextEvent.getServletContext();
            ctx.setAttribute("storeUserDaoJdbc", storeUserDaoJdbc);
            ctx.setAttribute("storeUserDaoHibernate", storeUserDaoHibernate);
            ctx.setAttribute("securityService", securityService);
            ctx.setAttribute("productDao", productDao);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

package ru.ivmiit.projectFixCourse.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.ivmiit.projectFixCourse.config.DaoConfig;
import ru.ivmiit.projectFixCourse.model.StoreUser;
import ru.ivmiit.projectFixCourse.security.SecurityService;
import ru.ivmiit.projectFixCourse.security.SecurityServiceImpl;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.IOException;

public class StoreUserDaoHibernateImpl implements StoreUserDao {

    private DaoConfig daoConfig;
    private SecurityService securityService;

    public StoreUserDaoHibernateImpl() {
        daoConfig = new DaoConfig();
        securityService=new SecurityServiceImpl();
    }

    @Override
    public boolean isExist(String login, String password) {
        StoreUser user = findbylogin(login);
        return user != null && securityService.checkPassword(password, user.getPassword());
    }

    @Override
    public StoreUser findbylogin(String login) {
        try {
            SessionFactory sessionFactory = daoConfig.getConfiguration().buildSessionFactory();
            Session session = sessionFactory.openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<StoreUser> query = cb.createQuery(StoreUser.class);
            Root<StoreUser> root = query.from(StoreUser.class);
            query.select(root).where(cb.equal(root.get("login"), login));
            Query<StoreUser> q = session.createQuery(query);
            StoreUser storeUser = null;
            try {
                storeUser = q.getSingleResult();
            } catch (NoResultException e) {
            }
            return storeUser;
        } catch (IOException e) {
            throw new Error(e.getMessage());
        }
    }

    @Transactional
    @Override
    public void save(StoreUser model) {
        try (Session session = daoConfig.getConfiguration().buildSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(model);
            transaction.commit();
        } catch (IOException e) {
            throw new Error(e.getMessage());
        }
    }
}

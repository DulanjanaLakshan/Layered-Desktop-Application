package dao;


import dao.custom.impl.CustomerDaoImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDAOFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    //factory method
    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerDaoImpl();
            case ITEM:
                return null;
            case ORDER:
                return null;
                /*return new OrderDAOImpl();*/
            case ORDERDETAILS:
                return null;
                /*return new OrderDetailsDAOImpl();*/
            case QUERYDAO:
                return null;
                /*return new QueryDAOImpl();*/
            default:
                return null;
        }
    }

    public enum DAOTypes {
        CUSTOMER, ITEM, ORDER, ORDERDETAILS, QUERYDAO
    }

}

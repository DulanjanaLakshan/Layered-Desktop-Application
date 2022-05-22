package bo;

import bo.custom.impl.CustomerBOImpl;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {
    }

    public static BoFactory getBOFactory() {
        if (boFactory == null) {
            boFactory = new BoFactory();
        }
        return boFactory;
    }

    public SuperBO getBO(BoTypes types) {
        switch (types) {
            case ITEM:
                return null;
                case CUSTOMER:
                return new CustomerBOImpl();
            case PURCHASE_ORDER:
                return null;
            default:
                return null;
        }
    }

    public enum BoTypes {
        CUSTOMER, ITEM, PURCHASE_ORDER
    }
}

//    ->Hibernate is an ORM framework.
//    ->It is one of the implementations of JPA.
//    ->It manages database operations like:
//          .Session management
//          .SQL generation
//          .Transactions


//      Hibernate Code Example
public Integer addEmployee(Employee employee){

    Session session = factory.openSession();
    Transaction tx = null;
    Integer employeeID = null;

    try {
        tx = session.beginTransaction();

        employeeID = (Integer) session.save(employee);

        tx.commit();
    } catch (HibernateException e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        session.close();
    }

    return employeeID;
}

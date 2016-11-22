public static List getMessages(int messageId)
  throws Message Exception
{
  SessionFactory session = new Configuration().configure().buildSessionFactory(); //would normally be created elsewhere and made
  //available to the app as a Java Native Directory Interface(JNDI) resource
  Session session = sessions.openSession();
  Transaction tx = null;
  try {
    tx = session.beginTransaction();
    
    List list = session.createQuery("from Message").list();
    
    tx.commit();
    tx = null;
    return list;
    
    } catch (HibernateException e){
      if( tx! = null) tx.rollback();
      log.log(Level.SEVERE, "Could not acquire message" ,e);
      throw new MotdException(
            "Failed to retrieve message from the database." ,e);
    } finally {
      session.close();
    }
 }

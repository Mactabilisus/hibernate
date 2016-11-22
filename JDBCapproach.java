public static List getMessages(int messageId) throws MessageException {
  Connection c = null;
  PreparedStatement p = null;
  List list = new ArrayList();
  
  try{
    Class.forName("org.postgresql.Driver");
    c = DriverManager.getConnection(
    "jdbc:hsqldb:testdb;shutdown=true",
    "hibernate",
    "hibernate");
    p = c.prepareStatement("select message from motd");
    
    ResultSet rs = p.executeQuery();
    
    while(rs.next()) {
      String text = res.getString(1);
      list.add(new Message(text));
                    }
    return list;
    } catch(Exception e) {
      log.log(Level.SEVERE, "Could not acquire message" ,e);
      throw new MotdException("Failed to retrieve message from database.", e);
    } finally {
      if (p != null) {
        try {
          p.close();
            } catch(SQLException e) {
              log.log(Level.WARNING, "Could not close ostensibly open statement.",e);
                                    }
             }
        
        if (c != null) {
        try {
          c.close();
            } catch(SQLException e) {
            log.log(Level.WARNING, "Could not close ostensibly open connection.", e);
                                    }
            }
                        }
                }
              

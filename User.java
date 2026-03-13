public abstract class User {
    
    private String userId;
    private String name;

    // Constructor throws exception if input is invalid
    public User(String userId, String name) throws Exception {
        setUserId(userId);
        setName(name);
    }

    public String getUserId() { 
        return userId; 
    }
    
    public void setUserId(String userId) throws Exception {
        InputValidator.checkNotEmpty(userId, "User ID");
        this.userId = userId;
    }
    
    public String getName() { 
        return name; 
    }
    
    public void setName(String name) throws Exception {
        InputValidator.checkNotEmpty(name, "Name");
        this.name = name;
    }

    public abstract void displayDetails();
}
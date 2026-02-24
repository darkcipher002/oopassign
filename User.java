public abstract class User {
    // Encapsulation: Private attributes
    private String userId;
    private String name;

    // Constructor with parameters using 'this'
    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    // Getters and Setters (Encapsulation requirement)
    public String getUserId() { 
        return userId; 
    }
    
    public void setUserId(String userId) { 
        this.userId = userId; 
    }
    
    public String getName() { 
        return name; 
    }
    
    public void setName(String name) { 
        this.name = name; 
    }

    // Abstract method: Has no body here, will be implemented by child classes
    public abstract void displayDetails();
}
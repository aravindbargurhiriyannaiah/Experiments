package com.funkyganesha.urlshortner.bean;

public class UrlShortnerConfiguration {
    private String username;
    private String password;
    private String hostname;
    private int port;
    private String database;
    private boolean authenticationRequired;
    private String collectionName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "UrlShortnerConfiguration{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", hostname='" + hostname + '\'' +
                ", port=" + port +
                ", database='" + database + '\'' +
                '}';
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getDatabase() {
        return database;
    }

    public void setAuthenticationRequired(boolean authenticationRequired) {
        this.authenticationRequired = authenticationRequired;
    }

    public boolean getAuthenticationRequired() {
        return authenticationRequired;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getCollectionName() {
        return collectionName;
    }
}

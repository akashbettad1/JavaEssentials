package com.java.examples.equalsAndHashcode;

import java.util.Objects;

/**
 * Prime Number Multiplication: This custom hash function uses prime numbers to reduce
 * hash collisions and improve bucket distribution in hash-based collections.
 *
 * Balanced Hash Codes: By combining userId and username this way, we reduce clustering
 * in hash tables, leading to better performance for large datasets.
 *
 * Other scenarios:
 * Database Entities: Use primary keys for equals and hashCode to represent unique rows in a table.
 * Composite Keys: When there’s no single primary key, use multiple fields to ensure uniqueness.
 * DTOs for APIs: Use business keys (like productCode) to represent unique data objects across systems.
 * Custom Hash Functions: For performance-critical applications, use customized hash functions to ensure optimal hash table distribution.
 */
public class User {

    private int userId;
    private String userName;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        int hash =17;
        hash = 31 * hash + Long.hashCode(userId);  // Using prime numbers for better distribution
        hash = 31 * hash + (userName != null ? userName.hashCode() : 0);
        return hash;
    }

}

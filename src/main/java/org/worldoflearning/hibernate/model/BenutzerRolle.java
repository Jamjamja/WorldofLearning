    package org.worldoflearning.hibernate.model;  
      
    import javax.persistence.Column;  
    import javax.persistence.Entity;  
    import javax.persistence.FetchType;  
    import javax.persistence.GeneratedValue;  
    import javax.persistence.GenerationType;  
    import javax.persistence.Id;  
    import javax.persistence.JoinColumn;  
    import javax.persistence.ManyToOne;  
    import javax.persistence.Table;  
      
    @Entity  
    @Table(name = "benutzer_rolle", catalog = "testdb")  
    public class BenutzerRolle {  
      
     @Id  
     @GeneratedValue(strategy = GenerationType.IDENTITY)  
     @Column(name = "benutzer_rolle_id", unique = true, nullable = false)  
     private Integer benutzerRolleId;  
      
     @ManyToOne(fetch = FetchType.LAZY)  
     @JoinColumn(name = "benutzername", nullable = false)  
     private Benutzer benutzer;  
      
     @Column(name = "rolle", nullable = false, length = 45)  
     private String rolle;  
      
     public Integer getUserRoleId() {  
      return benutzerRolleId;  
     }  
      
     public void setUserRoleId(Integer userRoleId) {  
      this.benutzerRolleId = userRoleId;  
     }  
      
     public Benutzer getBenutzer() {  
      return benutzer;  
     }  
      
     public void setUser(Benutzer benutzer) {  
      this.benutzer = benutzer;  
     }  
      
     public String getRolle() {  
      return rolle;  
     }  
      
     public void setRolle(String rolle) {  
      this.rolle = rolle;  
     }  
      
    }  
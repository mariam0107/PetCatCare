
package dao;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Cat1;
import model.GenderEnum;




@Stateless
public class CatDao {

    @PersistenceContext(unitName = "PetCatCarePU")
    private EntityManager em;

 
//    protected EntityManager getEntityManager() {
//        return em;
//    }

  
    public void addCat( Cat1 cat){
    em.persist(cat);
    }
   
  public void deleteCat(Long id) {
       Cat1 cat = em.find(Cat1.class,id);
        em.remove(cat);
        
    }

    
    public List<Cat1> showAll(){
        return (List<Cat1>)em.createQuery("SELECT e FROM Cat1 e").getResultList();
    
    }
    
    public Cat1 showOne(Long id){
       return em.find(Cat1.class, id);
   
    }
    public void updateName(Long id,String name){
        Cat1 c=em.find(Cat1.class, id);
        c.setName(name);
        em.persist(c);
    
    }
     public void updateAge(Long id,int age){
        Cat1 c=em.find(Cat1.class, id);
        c.setAge(age);
        em.persist(c);
    
    }
      public void updateOwnerName(Long id,String owner){
        Cat1 c=em.find(Cat1.class, id);
        c.setOwnerName(owner);
        em.persist(c);
    
    }
      public void updateColor(Long id,String color){
        Cat1 c=em.find(Cat1.class, id);
        c.setColor(color);
        em.persist(c);
    
    }
      public void updateType(Long id,String type){
        Cat1 c=em.find(Cat1.class, id);
        c.setType(type);
        em.persist(c);
    
    }
      public void updateGender(Long id,GenderEnum gender){
      Cat1 c=em.find(Cat1.class, id);
        c.setGender((GenderEnum) gender);
        em.persist(c);
      }
     
    
    public Cat1 findCat(Long id){
        return em.find(Cat1.class, id);
    
    }
//   public List<Cat> nameList(String name){
//       return em.createQuery("SELECT e FROM Cat e WHERE e.name=:name").getResultList();
//        
//    }
//   public List<Cat> idList(Long id){
//       return em.createQuery("SELECT e FROM Cat e WHERE e.id=:id").getResultList();
//        
//    }
    
}

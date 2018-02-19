package controller;

import dao.CatDao;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Cat1;
import model.GenderEnum;

@Named(value = "catController")
@RequestScoped
public class catController {

    private Long id;
    private Long filterId;
    private Long removeId;
    private Long updateId;
    private Long findId;
    private Long showId;
    private String name;
    private String type;
    private String color;
    private Integer age;
    private String ownerName;
    private GenderEnum gender;
    
    
  private List<Cat1> catList;


    @Inject
    private CatDao dao;


    public Long getFilterId() {
        return filterId;
    }

    public void setFilterId(Long filterId) {
        this.filterId = filterId;
    }

    
    public Long getFindId() {
        return findId;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public void setFindId(Long findId) {
        this.findId = findId;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public Long getRemoveId() {
        return removeId;
    }

    public void setRemoveId(Long removeId) {
        this.removeId = removeId;
    }

    public CatDao getDao() {
        return dao;
    }

    public void setDao(CatDao dao) {
        this.dao = dao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (isOnlyDigits(name)) {
            this.name = name;
        }
    }

    private boolean isOnlyDigits(String string) throws IllegalArgumentException {
        if (string.matches("[0-9]+")) {
            throw new IllegalArgumentException("The string contains only numbers: " + string);
        }
        return true;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public void add() {

        Cat1 c = new Cat1(name, type, color, (int) age, ownerName, gender);
        dao.addCat(c);

    }

    public String reset() {

        name = null;
        type = null;
        color = null;
        age = null;
        ownerName = null;
        gender = null;
        id = null;
        removeId = null;
        updateId = null;
        findId = null;
        showId = null;
        return "showOne";

    }

    public void delete() {
        dao.deleteCat(removeId);

    }

    public List<Cat1> showAll() {
        return dao.showAll();
    }


    public Cat1 showOne() {
        return dao.showOne(showId);
    }

    public void update() {
        dao.updateName(findId, name);
        dao.updateAge(findId, (int) age);
        dao.updateColor(findId, color);
        dao.updateOwnerName(findId, ownerName);
        dao.updateType(findId, type);
        dao.updateGender(findId, gender);

    }

    public void find() {
        Cat1 c = dao.findCat(findId);

        String newName = c.getName();
        setName(newName);

        int newAge = c.getAge();
        setAge((Integer) newAge);

        String newType = c.getType();
        setType(newType);

        String newColor = c.getColor();
        setColor(newColor);

        String newOwnerName = c.getOwnerName();
        setOwnerName(newOwnerName);

        GenderEnum newGender = c.getGender();
        setGender(newGender);
    }

    public void showOne1() {
        Cat1 c = dao.findCat(showId);

        String newName = c.getName();
        setName(newName);

        int newAge = c.getAge();
        setAge((Integer) newAge);

        String newType = c.getType();
        setType(newType);

        String newColor = c.getColor();
        setColor(newColor);

        String newOwnerName = c.getOwnerName();
        setOwnerName(newOwnerName);

        GenderEnum newGender = c.getGender();
        setGender(newGender);
    }
//   public List<Cat> idList2(){
//      catList= dao.idList(filterId);
//      return catList;
//      
//   
//   }
}

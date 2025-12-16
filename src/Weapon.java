public abstract class Weapon implements interactive {
    private final String name;
    private Room currentRoom;

    public Weapon(String name, Room currentRoom){
        this.name = name;
        this.currentRoom = currentRoom;
    }
    public String getName() {
        return name;
    }
    public Room getCurrentRoom(){
        return currentRoom;
    }
    public void changeLocation(Room newRoom) {
        this.currentRoom = newRoom;
    }

    @Override //переопределяем, чтобы выводилась информация про оружие
    public String toString() {
        return name + " находится в " + currentRoom.getName();
        //описание местонахождения оружия
    }
}

import java.util.Objects;

public abstract class Character {
    private final String name;
    private Room currentRoom;
    private final int weight;
    private int mood;

    public Character(String name, Room currentRoom, int weight, int mood){
        this.name = name;
        this.currentRoom = currentRoom;
        this.weight = weight;
        this.mood = mood;
    }

    public void moveTo(Room newRoom) {
        try{
            if (!newRoom.getAbility()) {
                System.out.println(getName() + "попытался попасть в " + getName());
                throw new RoomLocketException(newRoom);
                //выбрасываем исключение, если нужная комната закрыта
            }
            setCurrentRoom(newRoom); //меняем комнату в свойстве персонажа
            if (mood>=100) {
                System.out.println(name + " радостно зашёл в "
                        + newRoom.getName() + "\n");
            }
            System.out.println(name + " переместился в " + newRoom.getName() + "\n");
        } catch (RoomLocketException exception){
            //ловим исключение и выводим сообщение
            System.out.println(exception.getMessage());
        }
    }

    public void improveMood(int unit){
        this.mood = mood + unit;
    }

    public int getMood() {
        return mood;
    }
    public String getName() {
        return name;
    }
    public String getNameRoom() {
        return currentRoom.getName();
    }
    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(Room newRoom) {
        this.currentRoom = newRoom;
    }
    public abstract void lookAround();
    @Override
    public int hashCode(){
        return Objects.hash(name,currentRoom,weight,mood);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Character other = (Character) obj;
        return Objects.equals(name, other.name);
    }
    @Override
    public String toString() {
        return name + " находится в " + currentRoom.getName() +
                ", его вес равен " + weight + " кг, настроение " + mood;
        //описание персонажа
    }
}

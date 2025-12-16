public class Room {
    private final String name;
    private final RoomType roomType;
    private boolean abilityToOpen;

    public Room(String name, RoomType roomType, boolean abilityToOpen){
        this.name = name;
        this.roomType = roomType;
        this.abilityToOpen = abilityToOpen;
    }

    public boolean getAbility(){
        return abilityToOpen;
    }
    public void setAbility(boolean newAbility){
        this.abilityToOpen = newAbility;
    }
    public String getName() {
        return name;
    }
    public RoomType getRoomType() {
        return roomType;
    }
}

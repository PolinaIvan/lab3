public class RoomLocketException extends Exception {
    private final Room room;
    public RoomLocketException(Room room) {
        super();
        this.room=room;
    }
    @Override
    public String getMessage(){
        return "Но комната " +  room.getName() + " закрыта!\n";
    }
}

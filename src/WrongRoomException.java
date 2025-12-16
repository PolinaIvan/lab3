public class WrongRoomException extends RuntimeException{
    private final Room room;
    public WrongRoomException(Room room) {
        super();
        this.room = room;
    }
    @Override
    public String getMessage(){
        return "Персонаж не может взаимодействовать с этим предметом из комнаты "
                + room.getName() +"\n";
    }
}

public class MachineGun extends Weapon{
    public MachineGun(String name, Room currentRoom) {
        super(name, currentRoom); //вызов конструктора родительского класса
    }
    @Override
    public void interactWith(Character character){
        try {
            if (character.getCurrentRoom().equals(this.getCurrentRoom())) {
                if (character instanceof Kozlik) {
                    //если взаимодействует объект класса Kozlik
                    System.out.println(character.getName() + " одним глазком посмотрел на "
                            + getName() + " и задумался об обеде\n");
                } else {
                    //если взаимодействует не козлик
                    System.out.println(character.getName() + " без энтузиазма осмотрел "
                            + getName() + "\n");
                }
            } else {
                throw new WrongRoomException(character.getCurrentRoom());
            }
        } catch (WrongRoomException exception){
            System.out.println(exception.getMessage()); }
    }
}

public class Rifle extends Weapon{
    public Rifle(String name, Room currentRoom) {
        super(name, currentRoom); //вызов конструктора родительского класса
    }
    @Override
    public void interactWith(Character character) {
        try {
            if (character.getCurrentRoom().equals(this.getCurrentRoom())) {
                //проверяем, что персонаж и оружие находятся в одной комнате
                if (character instanceof Neznaika) {
                    System.out.println(character.getName() + " взял " +
                            getName() + " в руки, осмотрел и положил обратно\n");
                } else {
                    System.out.println(character.getName() + " глянул на "
                            + getName() + "\n");}
            } else {
                throw new WrongRoomException(character.getCurrentRoom());}
        } catch (WrongRoomException exception){
            System.out.println(exception.getMessage());}
    }
}

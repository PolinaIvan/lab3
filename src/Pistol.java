public class Pistol extends Weapon{
    public Pistol(String name, Room currentRoom) {
        super(name, currentRoom); //вызов конструктора базового класса
    }
    @Override
    public void interactWith(Character character){
        try {
            if (character.getCurrentRoom().equals(this.getCurrentRoom())) {
                //проверяем, что персонаж находится в той же комнате, что и пистолет
                if (character instanceof Neznaika) {
                    System.out.println(character.getName() +
                            " с интересом осмотрел " + getName() + "\n");
                    if (Math.random() < 0.7) {
                        //с вероятностью 70% незнайка возьмёт пистолет себе в инвентарь
                        ((Neznaika) character).addToInventory(this); }
                } else {
                    System.out.println(character.getName() + " осмотрел " + getName() + "\n");}
            } else {
                throw new WrongRoomException(character.getCurrentRoom());
            }
        } catch (WrongRoomException exception){
            System.out.println(exception.getMessage()); }
    }
}

public class Dagger extends Weapon{
    public Dagger(String name, Room currentRoom) {
        super(name, currentRoom); //вызов конструктора родительского класса
    }
    @Override
    public void interactWith(Character character){
        try {
            if (character.getCurrentRoom().equals(this.getCurrentRoom())) {
                //проверка что персонаж находится в одной комнате с оружием
                if (character instanceof Dzylio) {
                    //если персонаж является объектом класса Dzylio
                    System.out.println(character.getName() + " внимательно осмотрел "
                            + getName() + " и подумал, что уже когда то видел такой же\n");
                } else {
                    System.out.println(character.getName() + " без энтузиазма осмотрел "
                            + getName() + "\n");
                }
            } else {
                throw new WrongRoomException(character.getCurrentRoom());
                //бросаем исключение
            }
        } catch (WrongRoomException exception){
            System.out.println(exception.getMessage());
            //ловим исключение и выводим сообщение
        }
    }
}

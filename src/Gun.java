public class Gun extends Weapon {
    public Gun(String name, Room currentRoom) {
        super(name, currentRoom); //вызов конструктора родительского класса
    }

    @Override
    public void interactWith(Character character) {
        try {
            if (character.getCurrentRoom().equals(this.getCurrentRoom())) {
                //если оружие находится в той же комнате, что и персонаж
                if (character instanceof Kozlik) {
                    System.out.println(character.getName() + " внимательно осмотрел "
                            + getName() + " и подумал, что уже когда то видел такое же\n");
                } else {
                    System.out.println(character.getName() + " без энтузиазма осмотрел "
                            + getName() + "\n");
                }
            } else {
                throw new WrongRoomException(character.getCurrentRoom());
                //бросаем исключение, если оружие и персонаж в разных комнатах
            }
        } catch (WrongRoomException exception){
            System.out.println(exception.getMessage());
            //ловим исключение
        }
    }
}

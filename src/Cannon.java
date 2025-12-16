public class Cannon extends Weapon{
    public Cannon(String name, Room currentRoom) {
        super(name, currentRoom); //вызов конструктора родительского класса
    }
    @Override
    public void interactWith(Character character){
        try {
            if(character.getCurrentRoom().equals(this.getCurrentRoom())){
                //если персонаж находится в той же комнате, что и оружие
                System.out.println(character.getName() + " взглянул на "
                        + getName() + " и внимательно осмотрел\n");
            } else {
                throw new WrongRoomException(character.getCurrentRoom());
                //в противном случае выбрасываем исключение
            }
        } catch (WrongRoomException exception){
            System.out.println(exception.getMessage());
            //ловим исключение и выводим уведомление в консоль
        }
    }
}

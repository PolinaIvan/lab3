import java.util.List;
import java.util.ArrayList;
public class Neznaika extends Character{
    public Neznaika(String name, Room currentRoom, int weight, int mood){
        super(name, currentRoom, weight, mood);
    }

    private List<Weapon> inventory = new ArrayList<>();
    public void addToInventory(Weapon weapon) {
        System.out.println(getName() + " положил " + weapon.getName() + " к себе в карман");
        inventory.add(weapon);
        this.improveMood(20);
        //при получении оружия в инвентарь, настроение незнайки увеличивается
        System.out.println("У " + getName() + " улучшилось настроение на 20");
        printInventory();
    }
    public void printInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Инвентарь пуст\n");
        } else {
            System.out.print("Инвентарь Незнайки: ");
            for (Weapon weapon : inventory) {
                System.out.print(weapon.getName() + " "); }
            System.out.println("\n"); }
    }
    @Override
    public void moveTo(Room newRoom) {
        try {
            if (newRoom.getAbility()){ //выполняем если открыта дверь в комнату
                setCurrentRoom(newRoom);
                System.out.println(getName() + " переместился в " + newRoom.getName() + "\n");
                if (!inventory.isEmpty()){
                    for (Weapon weapon : inventory){
                        //меняем положение оружия вместе с персонажем
                        weapon.changeLocation(newRoom); }
                }
            } else {
                System.out.println(getName() + " попытался попасть в " + newRoom.getName());
                throw new RoomLocketException(newRoom);
                //выбрасываем исключение, если нужная комната закрыта
            }
        } catch (RoomLocketException exception){ //ловим исключение, если комната закрыта
            System.out.println(exception.getMessage()); //выводим сообщение об ошибке
        }
    }

    @Override
    public void lookAround(){
        if (this.getCurrentRoom().getRoomType() == RoomType.Storage){
            System.out.println("Попадя на склад, " + getName() +
                    " сразу обратил внимание на кучи ящиков с оружием\n");
        } else {
            System.out.println(getName() + " осмотрелся по сторонам, находясь в "
                    + getNameRoom() + "\n"); }
    }
}

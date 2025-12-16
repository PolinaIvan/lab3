public class Kozlik extends Character{
    public Kozlik(String name, Room currentRoom, int weight, int mood){
        super(name, currentRoom, weight, mood);
    }
    @Override
    public void lookAround(){
        if (this.getCurrentRoom().getRoomType() == RoomType.Storage){
            //если козлик находится в складе
            if (Math.random()<=0.7) {
                //с вероятностью 70% козлик находит морковь
                System.out.println(getName() + ", находясь на складе, " +
                        "осмотрелся и обратил внимание на подозрительный свёрток");
                System.out.println("Подойдя поближе, он унюхал сочную морковку " +
                        "и перекусил ею");
                this.improveMood(100); //у козлика увеличивается показатель настроения
                System.out.println("У " + getName() + " улучшилось настроение на 100\n");
            } else {
                System.out.println(getName() + ", находясь на складе, " +
                        "осмотрелся по сторонам и ничего особенного не заметил\n");
            }
        }
        else { //если козлик не на складе
            System.out.println(getName() + " осмотрелся по сторонам, находясь в "
                    + getNameRoom() + "\n");
        }}}

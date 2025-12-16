public class Dzylio extends Character{
    public Dzylio(String name, Room currentRoom, int weight, int mood){
        super(name, currentRoom, weight, mood);
    }
    @Override
    public void lookAround(){
        if (this.getCurrentRoom().getRoomType() == RoomType.Storage){
            //если Жулио находится на складе
            System.out.println(getName() + " решил внимательно осмотреть стены склада");
            if (getMood()>=70) {
                //если у Жулио хорошее настроение, то осматривает склад внимательно
                System.out.println("И обратил внимание на электрический щиток " +
                        "и кнопку рядом с ним");
            } else {
                System.out.println("И не нашёл ничего интересного, кроме кнопки");
            }
        } else { //если Жулио в любой другой комнате
            System.out.println(getName() + " осмотрелся по сторонам, находясь в "
                    + getNameRoom() + "\n");
        }}}

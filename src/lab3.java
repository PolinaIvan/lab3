public class lab3 {
    public static void main(String[] args) {
        Room corridor = new Room("Коридор",RoomType.Corridor,true);
        Room storage = new Room("Склад",RoomType.Storage,true);
        Room basement = new Room("Подземный гараж",RoomType.UndergroundGarage, false);

        Button button1 = new Button("Кнопка",storage,basement);

        Neznaika neznaika = new Neznaika("Незнайка", corridor,70,80);
        Kozlik kozlik = new Kozlik("Козлик",corridor,40,20);
        Dzylio dzylio = new Dzylio("Жулио",storage,60,70);

        Pistol pistol = new Pistol("Пистолет",storage);
        Cannon cannon = new Cannon("Пушка",storage);
        Dagger dagger = new Dagger("Кинжал",storage);
        Gun gun = new Gun("Ружьё",storage);
        MachineGun machineGun = new MachineGun("Пулемёт",storage);
        Rifle rifle = new Rifle("Автомат",storage);

        System.out.printf("%s%n%s%n%s%n%n", neznaika, kozlik, dzylio);

        neznaika.moveTo(storage); //перемещаем персонажей на склад
        kozlik.moveTo(storage);
        neznaika.moveTo(basement); //незнайка попробует попасть в подвал,
                                   //но сработает исключение
        neznaika.lookAround();
        kozlik.lookAround();

        pistol.interactWith(neznaika); //персонажи по очереди взаимодействуют с оружиями
        gun.interactWith(kozlik);
        cannon.interactWith(neznaika);
        machineGun.interactWith(kozlik);
        dagger.interactWith(neznaika);
        rifle.interactWith(kozlik);

        dzylio.lookAround(); //Жулио осматривается и находит кнопку
        button1.interactWith(dzylio); // нажимает на кнопку и открывает дверь в подвал

        neznaika.moveTo(basement); //персонажи перемещаются в подвал
        kozlik.moveTo(basement);
        dzylio.moveTo(basement);
    }
}

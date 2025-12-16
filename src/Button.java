public record Button(String name,Room currentRoom,Room openRoom) implements interactive {
    @Override
    public void interactWith(Character character){
        try {
            if (currentRoom.equals(character.getCurrentRoom())) {
                //если персонаж находится в той же комнате, что и кнопка
                openRoom.setAbility(true); //теперь дверь в комнату открыта
                System.out.println(character.getName() + " нажал " + name() +
                        ", и открылась дверь в " + openRoom.getName() + "\n");
            } else {
                throw new WrongRoomException(character.getCurrentRoom());
                //выбрасываем исключение, если кнопка в другой комнате
            }
        } catch (WrongRoomException exception){
            System.out.println(exception.getMessage());
        }
    }
}

package dao;

import models.Arena;
import models.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class ArenaDao {

    public void addArena(Object object) {
        Data data = new Data();
        data.addData(object);
    }

    public Arena getArena(Scanner input) {
        System.out.print("enter arena Id you want to get:");
        int id = input.nextInt();
        Data data = new Data();
        return (Arena) data.getData(Arena.class, id);
    }

    public Collection<Arena> getAllArenas() {
        Data data = new Data();
        Collection<Object> dataList = data.getDataList(Arena.class);
        Collection<Arena> outputList = new ArrayList<>();
        for (Object o : dataList) {
            outputList.add((Arena) o);
        }
        return outputList;
    }

    public void printAllArenas(Collection<Arena> arenas) {
        for (Arena arena : getAllArenas()) {
            System.out.println(arena);

        }
    }

    public void deleteArena(Scanner input) {
        System.out.print("enter arena Id you want to delete:");
        int id = input.nextInt();
        Data data = new Data();
        data.deleteData(Arena.class, id);
    }

   /* public void editArena(int id, Object[] objectDat) {
        // 0-arenaName 1-addressId 2-indoors
        Data data = new Data();
        Arena arena = (Arena) data.getData(Arena.class, id);
        // use objectData array
        arena.setArenaName((String) objectDat[0]);
        arena.setAddressId((Integer) objectDat[1]);
        arena.setIndoors((Boolean) objectDat[2]);
        Data data2 = new Data();
        data2.editData(Arena.class, arena);
    }
*/
   public void editArena(Scanner input) {
       System.out.print("enter arena Id you want to edit:");
       int id = input.nextInt();
       Data data = new Data();
       Arena arena = (Arena) data.getData(Arena.class, id);
       System.out.print("enter arena name:");
       String name = input.next();
       arena.setArenaName(name);

       System.out.print("enter arena address Id:");
       int add = input.nextInt();
       arena.setAddressId(add);

       System.out.print("is the arena indoors:");
       boolean flag = input.nextBoolean();
       arena.setIndoors(flag);

       // we want to see what is the difference
       Data data2 = new Data();
       data2.editData(Arena.class, arena);

       //addArena(arena);


   }
    public void insertArena(Scanner input) {
        // 0-arenaName 1-addressId 2-indoors
        Arena arena = new Arena();
        System.out.print("enter arena name:");
        String name = input.next();
        arena.setArenaName(name);

        System.out.print("enter arena address Id:");
        int add = input.nextInt();
        arena.setAddressId(add);

        System.out.print("is the arena indoors:");
        boolean flag = input.nextBoolean();
        arena.setIndoors(flag);

        addArena(arena);

    }
}
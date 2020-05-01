/*

A sports shop inventory.
Product categories: Cricket and Football
Subcategories: Equipment and Clothing

*/

import java.util.*;

class Cricket {
    private HashMap<String, Integer> equip = new HashMap<>();
    private HashMap<String, Integer> cloth = new HashMap<>();

    public void addEquip(String a, Integer b) {
        if (!this.equip.containsKey(a))
            this.equip.put(a, b);
        else
            this.equip.put(a, b + this.equip.get(a));
    }

    public void addCloth(String a, Integer b) {
        if (!this.cloth.containsKey(a))
            this.cloth.put(a, b);
        else
            this.cloth.put(a, b + this.cloth.get(a));
    }

    public void removeEquip(String a, Integer b) {
        if (!this.equip.containsKey(a))
            System.out.println("Item Not Found!!");
        else {
            if (b > this.equip.get(a)) {
                System.out.println("Not Sufficient Items!!");
                System.out.println("Available: " + this.equip.get(a));
            } else
                this.equip.put(a, this.equip.get(a) - b);
        }
    }

    public void removeCloth(String a, Integer b) {
        if (!this.cloth.containsKey(a))
            System.out.println("Item Not Found!!");
        else {
            if (b > this.cloth.get(a)) {
                System.out.println("Not Sufficient Items!!");
                System.out.println("Available: " + this.cloth.get(a));
            } else
                this.cloth.put(a, this.cloth.get(a) - b);
        }
    }

    public void showItems() {
        System.out.println("Cricket Equipments: " + this.equip);
        System.out.println("Cricket Clothing: " + this.cloth);
    }
}

class Football {
    private HashMap<String, Integer> equip = new HashMap<>();
    private HashMap<String, Integer> cloth = new HashMap<>();

    public void addEquip(String a, Integer b) {
        if (!this.equip.containsKey(a))
            this.equip.put(a, b);
        else
            this.equip.put(a, b + this.equip.get(a));
    }

    public void addCloth(String a, Integer b) {
        if (!this.cloth.containsKey(a))
            this.cloth.put(a, b);
        else
            this.cloth.put(a, b + this.cloth.get(a));
    }

    public void removeEquip(String a, Integer b) {
        if (!this.equip.containsKey(a))
            System.out.println("Item Not Found!!");
        else {
            if (b > this.equip.get(a)) {
                System.out.println("Not Sufficient Items!!");
                System.out.println("Available: " + this.equip.get(a));
            } else
                this.equip.put(a, this.equip.get(a) - b);
        }
    }

    public void removeCloth(String a, Integer b) {
        if (!this.cloth.containsKey(a))
            System.out.println("Item Not Found!!");
        else {
            if (b > this.cloth.get(a)) {
                System.out.println("Not Sufficient Items!!");
                System.out.println("Available: " + this.cloth.get(a));
            } else
                this.cloth.put(a, this.cloth.get(a) - b);
        }
    }

    public void showItems() {
        System.out.println("Football Equipments: " + this.equip);
        System.out.println("Football Clothing: " + this.cloth);
    }
}

class Inventory {
    private Cricket c = new Cricket();
    private Football f = new Football();

    public void addCricEquip(String a, Integer b) {
        this.c.addEquip(a, b);
    }

    public void addCricCloth(String a, Integer b) {
        this.c.addCloth(a, b);
    }

    public void addFootEquip(String a, Integer b) {
        this.f.addEquip(a, b);
    }

    public void addFootCloth(String a, Integer b) {
        this.f.addCloth(a, b);
    }

    public void rmCricEquip(String a, Integer b) {
        this.c.removeEquip(a, b);
    }

    public void rmCricCloth(String a, Integer b) {
        this.c.removeCloth(a, b);
    }

    public void rmFootEquip(String a, Integer b) {
        this.f.removeEquip(a, b);
    }

    public void rmFootCloth(String a, Integer b) {
        this.f.removeCloth(a, b);
    }

    public void showInventory() {
        this.c.showItems();
        this.f.showItems();
    }
}

public class SportsShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory shop = new Inventory();
        while(true) {
            System.out.println("1) Add Item, 2) Remove Item, 3) See Inventory, (Other) to Quit");
            System.out.println("Enter choice: ");
            String ch = sc.nextLine();
            if (ch.equals("1")) {
                while(true) {
                    System.out.println("1) Add Cricket Equipment, 2) Add Football Equipment, 3) Add Cricket Clothing, " +
                            "4) Add Football Clothing, (Other) to Quit");
                    System.out.println("Enter choice: ");
                    String c = sc.nextLine();
                    String item;
                    int count;
                    if (c.equals("1")) {
                        System.out.println("Enter Item Name: ");
                        item = sc.nextLine();
                        System.out.println("Enter Count: ");
                        count = sc.nextInt();
                        shop.addCricEquip(item, count);
                    } else if (c.equals("2")) {
                        System.out.println("Enter Item Name: ");
                        item = sc.nextLine();
                        System.out.println("Enter Count: ");
                        count = sc.nextInt();
                        shop.addFootEquip(item, count);
                    } else if (c.equals("3")) {
                        System.out.println("Enter Item Name: ");
                        item = sc.nextLine();
                        System.out.println("Enter Count: ");
                        count = sc.nextInt();
                        shop.addCricCloth(item, count);
                    } else if (c.equals("4")) {
                        System.out.println("Enter Item Name: ");
                        item = sc.nextLine();
                        System.out.println("Enter Count: ");
                        count = sc.nextInt();
                        shop.addFootCloth(item, count);
                    } else break;
                    sc.nextLine();
                }
            } else if (ch.equals("2")) {
                while(true) {
                    System.out.println("1) Remove Cricket Equipment, 2) Remove Football Equipment, 3) Remove Cricket Clothing, " +
                            "4) Remove Football Clothing, (Other) to Quit");
                    System.out.println("Enter choice: ");
                    String c = sc.nextLine();
                    String item;
                    int count;
                    if (c.equals("1")) {
                        System.out.println("Enter Item Name: ");
                        item = sc.nextLine();
                        System.out.println("Enter Count to remove: ");
                        count = sc.nextInt();
                        shop.rmCricEquip(item, count);
                    } else if (c.equals("2")) {
                        System.out.println("Enter Item Name: ");
                        item = sc.nextLine();
                        System.out.println("Enter Count to remove: ");
                        count = sc.nextInt();
                        shop.rmFootEquip(item, count);
                    } else if (c.equals("3")) {
                        System.out.println("Enter Item Name: ");
                        item = sc.nextLine();
                        System.out.println("Enter Count to remove: ");
                        count = sc.nextInt();
                        shop.rmCricCloth(item, count);
                    } else if (c.equals("4")) {
                        System.out.println("Enter Item Name: ");
                        item = sc.nextLine();
                        System.out.println("Enter Count to remove: ");
                        count = sc.nextInt();
                        shop.rmFootCloth(item, count);
                    } else break;
                    sc.nextLine();
                }
            } else if (ch.equals("3")) {
                shop.showInventory();
            } else break;
        }
    }
}

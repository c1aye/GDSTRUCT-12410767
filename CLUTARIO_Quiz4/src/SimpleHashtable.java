public class SimpleHashtable {
    private SavedPlayer[] hashtable;

    public SimpleHashtable() {
        hashtable = new SavedPlayer[10];
    }

    public int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public int findKey(String key) {
        int hashedKey = hashKey(key);

        // already correct hashedKey
        if (isOccupied(hashedKey) && hashtable[hashedKey].getKey().equals(key)) {
            return hashedKey;
        }

        // perform linear probing
        int stoppingIndex = hashedKey;

        if (hashedKey == hashtable.length - 1) { // end of array
            hashedKey = 0;
        }
        else {
            hashedKey++;
        }

        while (hashedKey != stoppingIndex &&
                isOccupied(hashedKey) &&
                !hashtable[hashedKey].getKey().equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (isOccupied(hashedKey) && hashtable[hashedKey].getKey().equals(key)) { // saved player found
            return  hashedKey;
        }

        return -1;
    }

    public boolean isOccupied(int hashedKey) {
        return hashtable[hashedKey] != null;
    }

    public void put(String key, Player value) {
        int hashedKey = hashKey(key);

        // perform linear probing
        if (isOccupied(hashedKey)) {
            int stoppingIndex = hashedKey;

            if (hashedKey == hashtable.length - 1) {    // hashed key is already at the end of the array
                hashedKey = 0;
            }
            else {
                hashedKey++;
            }

            while (hashedKey != stoppingIndex && hashtable[hashedKey] != null) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (isOccupied(hashedKey)) {    // hashed key is already taken
            System.out.println("Cannot put player " + key + ". Hashtable is full.");
        }
        else {
            hashtable[hashedKey] = new SavedPlayer(key, value);
        }
    }

    public Player get(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            return null;
        }

        return hashtable[hashedKey].getValue();
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            Player player = null;

            if (hashtable[i] != null)
                player = hashtable[i].getValue();

            System.out.println("Element " + i + " = " + player);
        }
    }

    public void remove(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            System.out.println("Key does not exist!");
            return;
        }

        System.out.println("Removed " + key);
        hashtable[hashedKey] = null;

        // Rehash all entries to maintain probing sequence
        SavedPlayer[] oldHashtable = hashtable;
        hashtable = new SavedPlayer[oldHashtable.length];

        for (SavedPlayer savedPlayer : oldHashtable) {
            if (savedPlayer != null) {
                put(savedPlayer.getKey(), savedPlayer.getValue());
            }
        }
    }

}
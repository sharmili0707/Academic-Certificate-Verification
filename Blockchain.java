import java.util.ArrayList;

public class Blockchain {
    private ArrayList<Block> chain;

    public Blockchain() {
        chain = new ArrayList<>();
        chain.add(createGenesisBlock());
        System.out.println("Blockchain created.");
    }

    private Block createGenesisBlock() {
        return new Block(0, "0", "Genesis Block");
    }

    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    public void addBlock(Block newBlock) {
        chain.add(newBlock);
        System.out.println("Block added: " + newBlock.data);
    }

    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block current = chain.get(i);
            Block previous = chain.get(i - 1);

            if (!current.hash.equals(current.calculateHash())) {
                return false;
            }
            if (!current.previousHash.equals(previous.hash)) {
                return false;
            }
        }
        return true;
    }

    public void displayChain() {
        for (Block b : chain) {
            System.out.println("\nBlock " + b.index + " : " + b.data);
            System.out.println("Hash: " + b.hash);
            System.out.println("Previous: " + b.previousHash);
        }
    }

    public void verifyCertificate(String certificateId) {
        boolean found = false;
        for (Block b : chain) {
            if (b.data.contains(certificateId)) {
                System.out.println("\n Certificate FOUND in blockchain:");
                System.out.println(b.data);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\n Certificate NOT found or may be fake!");
        }
    }
}




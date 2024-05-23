package io.codeforall.bootcamp.genie;

/**
 * Grumpy Genie that will grant only one wish and refuse all other requests
 */
public class GrumpyGenie extends Genie {

    /**
     * Calls the parent constructor
     * @see Genie#Genie(int)
     */
    public GrumpyGenie(int wishLimit) {
        super(wishLimit);
    }

    /**
     * @see Genie#canGrantWish()
     */
    @Override
    public boolean canGrantWish() {
        return getGrantedWishes() == 0;
    }

    /**
     * @see Genie#toString()
     */
    @Override
    public String toString() {

        return getGrantedWishes() == 0 ? "Grumpy genie has a wish to grant." : "Grumpy genie has granted a wish.";

    }

}

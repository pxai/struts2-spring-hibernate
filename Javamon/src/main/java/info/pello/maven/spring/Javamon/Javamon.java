package info.pello.maven.spring.Javamon;

import java.util.Random;

/**
 * represents a Javamon creature
 * @author Pello
 * @greetz Vigor jauna, 2DAMeko ikaslea
 */
public class Javamon {
    private String name;
    private int strength;
    private int defence;
    private int agility;
    private int life;
    private Random random = new Random();
    
    /**
     * constructor
     * @param nombre
     */
    public Javamon(String nombre) {
        this.name = nombre;
        initAttributes();
    }
    
    /**
     * intis javamon attributes randomly
     */
    private void initAttributes () {
        int pointsToDeal = 18;
        
        // to what attrib we give the points in each loop
        int whatAttrib = 0;
        
        // points to give at most en each loop
        int max = 0;
        
        // first they are 0
        strength = defence = agility = 0;
        while (pointsToDeal > 0) {
            whatAttrib = random.nextInt(3);
            switch (whatAttrib) {
                case 0:
                    strength++;
                    break;
                case 1:
                    defence++;
                    break;
                case 2:
                    agility ++;
                    break;
                default: break; // esto por manía. nevermind
            }
            // y vamos restando...
            pointsToDeal--;
        }
        
        // Y la vida dependerá de F y D
        life = strength + defence + 6;
    }
    
    /**
     * an initiative roll
     * @return
     */
    public int initiative () {
        return agility + random.nextInt(6);
    }
    
    /**
     * an attacking roll
     * @return
     */
    public int attack () {
        return strength + random.nextInt(6);        
    }

    /**
     * a defending roll
     * @return
     */
    public int defend () {
        return ((agility + defence) /2 ) + random.nextInt(6);

    }
    
    /**
     * javamon status description
     * @return
     */
    public String status (){
        return name +"(" + life + ")| S:" + strength + "| D:" + defence + "| A:" + agility;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * @return the defence
     */
    public int getDefence() {
        return defence;
    }

    /**
     * @return the agility
     */
    public int getAgility() {
        return agility;
    }

    /**
     * @return the life
     */
    public int getLife() {
        return life;
    }
    
    /**
     * @param life
     */
    public void setLife(int life) {
        this.life = life;
    }

}
package com.model;

public class Champion {

    public Champion(int armor, int attack, int life, String name) {
        this._armor = armor;
        this._attack = attack;
        this._life = life;
        this._name = name;
    }

    public int getAttack() {
        return _attack;
    }

    public int getLife() {
        return _life;
    }

    public String status() {
        return String.format(
            "%s: %s of life %s", _name, _life, _checkIsDead());
    }

    public void takeDamage(Champion championAdversary) {
        int damage = championAdversary.getAttack() - _armor;

        if (damage <= 0) {
            _life -= 1;
        }
        else if (_life - damage < 0){
            _life = 0;
        }
        else {
            _life -= damage;
        }
    }

    private String _checkIsDead() {
        if (_life <= 0) {
            return "(is dead)";
        }

        return "";
    }

    private final int _armor;

    private final int _attack;

    private final String _name;

    private int _life;

}

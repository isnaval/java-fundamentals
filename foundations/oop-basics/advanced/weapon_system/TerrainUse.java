package java_oop.advanced.weapon_system;

public interface TerrainUse {
	void deploy();

	void move(int x, int y);

	boolean canTraverse(String terrainType);

	int getMovementSpeed();

}

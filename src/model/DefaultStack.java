package model;

public abstract class DefaultStack
{
	protected int size;

	public abstract void push(Cell e);
	public abstract Cell pop();
	public abstract Cell top();
	public abstract boolean isFull();
	public abstract boolean isEmpty();
	public abstract void printStack();
}

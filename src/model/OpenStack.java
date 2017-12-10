package model;

import java.util.ArrayList;
import java.util.List;

public class OpenStack extends DefaultStack
{
	private List<Cell> stack;

	public OpenStack() {
		this.stack = new ArrayList<>();
		this.size = 0;
	}

	@Override
	public void push(Cell e) {
		stack.add(e);
	}

	@Override
	public Cell pop() {
		Cell e = stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		return e;
	}

	@Override
	public Cell top() {
		return stack.get(stack.size()-1);
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public void printStack() {
		for(int i = 0; i < stack.size(); i++) {
			System.out.print(stack.get(i) + " ");
		}
		System.out.println();
	}
}

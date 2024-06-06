defmodule Darts do
  @type position :: {number, number}

  @doc """
  Calculate the score of a single dart hitting a target
  """
  @spec score(position) :: integer
  def score({x, y}) do
    cond do
      x < 1 and y < 1 -> 10
      (x >= 1 and x < 5) and (y >= 1 and y < 5) -> 5
      (x >= 5 and x <= 10) and (y >= 5 and y <= 10) -> 1
      x > 10 and y > 10 -> 0
      true -> 0
    end
  end
end

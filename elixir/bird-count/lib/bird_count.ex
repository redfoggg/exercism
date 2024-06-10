defmodule BirdCount do
  def today(list) do
    case(list) do
      [] -> nil
      [head | _tail ] -> head
    end
  end

  def increment_day_count(list) when list == [], do: [1]
  def increment_day_count([head | tail]), do: [head + 1 | tail]

  def has_day_without_birds?(list), do: 0 in list

  def total(list) when list == [] do
    0
  end

  def total([head | tail]) do
    head + total(tail)
  end

  def busy_days(list) when list == [] do
    0
  end
  
  def busy_days([head | tail]) do
    cond do
      head >= 5 -> 1 + busy_days(tail)
      true -> busy_days(tail)
     end 
  end
end

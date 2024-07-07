defmodule Username do
  def sanitize(username) do
    sanitize(username, [])
  end

  def sanitize([], acc) do
    Enum.reverse(acc)
  end

  def sanitize([head | tail], acc) do
    case head do
      head when head == ?ä -> sanitize(tail, [?e | [?a | acc]])
      head when head == ?ö -> sanitize(tail, [?e | [?o | acc]])
      head when head == ?ü -> sanitize(tail, [?e | [?u | acc]])
      head when head == ?ß -> sanitize(tail, [?s | [?s | acc]])
      head when (head <= ?z and head >= ?a) or head == ?_ -> sanitize(tail, [head | acc])
      _ -> sanitize(tail, acc)
    end
  end
end

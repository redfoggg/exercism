defmodule LogLevel do
  def to_label(level, legacy?) do
    # Please implement the to_label/2 function
    case level do
      0 when not legacy? -> :trace
      1 -> :debug
      2 -> :info
      3 -> :warning
      4 -> :error
      5 when not legacy? -> :fatal
      _ -> :unknown
    end
  end

  def alert_recipient(level, legacy?) do
    # Please implement the alert_recipient/2 function
    log_label = to_label(level, legacy?)

    case log_label do
      label when label in [:error, :fatal] -> :ops
      :unknown when legacy? -> :dev1
      :unknown -> :dev2
      _ -> false
    end
  end
end
